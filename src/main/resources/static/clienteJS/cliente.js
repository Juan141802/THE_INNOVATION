

$(document).ready(function() {    
    $('#clientes').DataTable({        
        language: {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",
            },
        
        responsive: "true",
        dom: 'Bfrtilp',       
        buttons:[ 
			{
				extend:    'excelHtml5',
				text:      '<i class="fas fa-file-excel"></i> ',
				titleAttr: 'Exportar a Excel',
				className: 'btn btn-success'
			},
			{
				extend:    'pdfHtml5',
				text:      '<i class="fas fa-file-pdf"></i> ',
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
			{
				extend:    'print',
				text:      '<i class="fa fa-print"></i> ',
				titleAttr: 'Imprimir',
				className: 'btn btn-info'
			},
		]	        
    });     
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

	 
        