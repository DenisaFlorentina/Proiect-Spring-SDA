
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(client, status){
          $('#clientidEdit').val(client.clientid);
          $('#clientnameEdit').val(client.clientname);
          $('#clientaddressEdit').val(client.clientaddress);
          $('#clientphoneEdit').val(client.clientphone);
          $('#clientmailEdit').val(client.clientmail);
            $('#ddlWorkEdit').val(client.workid);
            $('#ddlPlumberEdit').val(client.plumberid);
        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(client, status){
            $('#clientidDetails').val(client.clientid);
            $('#ddlWorkDetails').val(client.workid);
            $('#ddlPlumberDetails').val(client.plumberid);
            $('#clientnameDetails').val(client.clientname);
            $('#clientaddressDetails').val(client.clientaddress);
            $('#clientphoneDetails').val(client.clientphone);
            $('#clientmailDetails').val(client.clientmail);
            $('#lastModifiedByDetails').val(client.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });
    $('table #deleteButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');

        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    });
});