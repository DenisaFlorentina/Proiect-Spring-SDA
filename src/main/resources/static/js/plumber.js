
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(plumber, status){
            $('#plumberidEdit').val(plumber.plumberid);
            $('#plumbernameEdit').val(plumber.plumbername);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(plumber, status){
            $('#plumberidDetails').val(plumber.plumberid);
            $('#plumbernameDetails').val(plumber.plumbername);
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