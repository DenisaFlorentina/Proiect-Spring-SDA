
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(role, status){
            $('#idEdit').val(role.id);
            // $('#ddlUserEdit').val(role.id);
            $('#nameEdit').val(role.name);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(role, status){
            $('#idDetails').val(role.id);
            // $('#ddlUserDetails').val(role.id);
            $('#nameDetails').val(role.name);
            $('#lastModifiedByDetails').val(role.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    })
});