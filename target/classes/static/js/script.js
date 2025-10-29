const api = '/api/appointments';

async function fetchAppointments(){
  const res = await fetch(api);
  const data = await res.json();
  const root = document.getElementById('appointmentsList');
  if(!data.length){ root.innerHTML = '<p>Nenhum agendamento encontrado.</p>'; return; }
  const list = document.createElement('div');
  list.className = 'list';
  data.forEach(a=>{
    const el = document.createElement('div');
    el.className = 'appt';
    el.innerHTML = `<strong>${a.clientName}</strong> — <em>${a.service}</em><br/>
      ${new Date(a.appointmentAt).toLocaleString()}<br/>
      <small>${a.phone} ${a.notes?(' — '+a.notes):''}</small>
      <div><button data-id="${a.id}" class="del">Cancelar</button></div>`;
    list.appendChild(el);
  });
  root.innerHTML = '';
  root.appendChild(list);

  document.querySelectorAll('.del').forEach(btn=>{
    btn.onclick = async (e)=>{
      const id = btn.dataset.id;
      if(!confirm('Cancelar este agendamento?')) return;
      await fetch(api + '/' + id, {method:'DELETE'});
      fetchAppointments();
    }
  });
}

document.getElementById('appointmentForm').onsubmit = async (e)=>{
  e.preventDefault();
  const form = new FormData(e.target);
  const payload = {
    clientName: form.get('clientName'),
    phone: form.get('phone'),
    service: form.get('service'),
    notes: form.get('notes'),
    appointmentAt: form.get('appointmentAt')
  };
  // convert local datetime-local to ISO
  if(payload.appointmentAt){
    payload.appointmentAt = new Date(payload.appointmentAt).toISOString();
  }
  const res = await fetch(api, {
    method: 'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify(payload)
  });
  if(res.ok){
    alert('Agendamento criado com sucesso!');
    e.target.reset();
    fetchAppointments();
  } else {
    const txt = await res.text();
    alert('Erro: ' + txt);
  }
}

window.addEventListener('load', ()=>{ fetchAppointments(); });
