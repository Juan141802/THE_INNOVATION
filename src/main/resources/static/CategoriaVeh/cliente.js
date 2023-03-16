


$(document).ready(function () {
    $('#example').DataTable();
});


function eliminar(){

	var id_cliente = document.getElementById().value;
	location.href="/cliente/eliminar/" + id_cliente;
	
}

function confirmar(id_cliente){
	Swal.fire({
  title: 'Desea Eliminar El Cliente' + id_cliente +'?',
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: 'd33',
  confirmButtonText: 'Confirmar',
}).then((result) => {
 
  if (result.isConfirmed) {
    Swal.fire(id_cliente + ' Eliminado!', '', 'success')
  } location.href = "/cliente/eliminar/" + id_cliente;
})

}