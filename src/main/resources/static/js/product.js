
$('document').ready(function(){
    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $.get(href, function(product, status){
            $('#productidEdit').val(product.productid);
            $('#productnameEdit').val(product.productname);
            $('#productpriceEdit').val(product.productprice);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(product, status){
            $('#productidDetails').val(product.productid);
            $('#productnameDetails').val(product.productname);
            $('#productpriceDetails').val(product.productprice);
            $('#lastModifiedByDetails').val(product.lastModifiedBy);
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