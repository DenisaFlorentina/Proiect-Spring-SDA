
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
        });
        $('#editModal').modal();
    });
});