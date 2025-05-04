// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();
    actualizarEmailDelUsuario();
  $('#usuarios').DataTable();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}

async function cargarUsuarios() {

    const request = await fetch('/api/usuarios', {
        method: 'GET',
        headers: getHeaders()
      });
    let usuarios;
    try {
      usuarios = await request.json();
      console.log("Respuesta del servidor:", usuarios);
    } catch (e) {
      console.error("Error al parsear JSON:", e);
    }



    let listadoHtml = '';
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let usuarioHtml = '<tr> <td> ' + usuario.id

         + '</td>  <td>' + usuario.nombre + '  ' + usuario.apellido + '</td>  <td>' + usuario.email+ ' </td>  <td>'+usuario.telefono+'</td><td> ' + botonEliminar + ' </td></tr>';
        listadoHtml += usuarioHtml;
    }


    document.querySelector("#usuarios tbody").innerHTML = listadoHtml;


}

function getHeaders() {
    return {
                       'Accept': 'application/json',
                       'Content-Type': 'application/json',
                       'Authorization': localStorage.token
                   };
}

async function eliminarUsuario(id) {

    if (!confirm('¿Desea eliminar este usuario?')) {
        return;
    }

    const request = await fetch('/api/usuarios/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    // Agregá esto si querés recargar los usuarios después de eliminar
    cargarUsuarios()
    location.reload();
}
