
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(user, role, status){
            $('#idEdit').val(user.id);
            $('#ddlRoleEdit').val(role.name);
            $('#firstnameEdit').val(user.firstname);
            $('#lastnameEdit').val(user.lastname);
            $('#usernameEdit').val(user.username);
            $('#passwordEdit').val(user.password);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(user, role, status){
            $('#idDetails').val(user.id);
            $('#ddlRoleDetails').val(role.name);
            $('#firstnameDetails').val(user.firstname);
            $('#lastnameDetails').val(user.lastname);
            $('#usernameDetails').val(user.username);
            $('#passwordDetails').val(user.password);
            $('#lastModifiedByDetails').val(user.lastModifiedBy);
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