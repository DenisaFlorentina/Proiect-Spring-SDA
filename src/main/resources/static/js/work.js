
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(work, status){
            $('#workidEdit').val(work.workid);
            $('#ddlClientEdit').val(work.clientid);
            $('#ddlPlumberEdit').val(work.plumberid);
            $('#worknameEdit').val(work.workname);
            $('#workpriceEdit').val(work.workprice);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(work, status){
            $('#workidDetails').val(work.workid);
            $('#ddlClientDetails').val(work.clientid);
            $('#ddlPlumberDetails').val(work.plumberid);
            $('#worknameDetails').val(work.workname);
            $('#workpriceDetails').val(work.workprice);
            $('#lastModifiedByDetails').val(work.lastModifiedBy);
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