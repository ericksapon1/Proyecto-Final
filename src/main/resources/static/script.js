$(document).ready(function() {
    // Función para crear un proyecto
    $('#btnCrearProyecto').on('click', function() {
        // Obtener los datos del formulario
        var nombre = $('input[name="nombre"]').val();
        var descripcion = $('input[name="descripcion"]').val();

        // Validar que no estén vacíos
        if (nombre && descripcion) {
            // Enviar la solicitud AJAX
            $.ajax({
                url: '/api/proyectos',  // Ruta de la API
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombre: nombre,
                    descripcion: descripcion
                }),
                success: function(proyecto) {
                    // Actualizar la lista de proyectos en la página sin recargarla
                    $('#listaProyectos').append('<li>' + proyecto.nombre + ' - ' + proyecto.descripcion + '</li>');
                    // Limpiar el formulario
                    $('input[name="nombre"]').val('');
                    $('input[name="descripcion"]').val('');
                },
                error: function() {
                    alert('Error al crear el proyecto');
                }
            });
        } else {
            alert('Por favor, completa todos los campos');
        }
    });

    // Función para crear una tarea
    $('#btnCrearTarea').on('click', function() {
        // Obtener los datos del formulario
        var nombreTarea = $('input[name="nombre"]').val();
        var descripcionTarea = $('input[name="descripcion"]').val();

        // Validar que no estén vacíos
        if (nombreTarea && descripcionTarea) {
            // Enviar la solicitud AJAX
            $.ajax({
                url: '/api/tareas',  // Ruta de la API
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombre: nombreTarea,
                    descripcion: descripcionTarea
                }),
                success: function(tarea) {
                    // Actualizar la lista de tareas en la página sin recargarla
                    $('#listaTareas').append('<li>' + tarea.nombre + ' - ' + tarea.descripcion + '</li>');
                    // Limpiar el formulario
                    $('input[name="nombre"]').val('');
                    $('input[name="descripcion"]').val('');
                },
                error: function() {
                    alert('Error al crear la tarea');
                }
            });
        } else {
            alert('Por favor, completa todos los campos');
        }
    });
});
