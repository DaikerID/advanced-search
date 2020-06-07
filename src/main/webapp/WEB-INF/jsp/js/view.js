
$(function () {
  $(document).ready(function () {
    $('select').material_select();
  });

  //============-------------ADDING_FIELDS-----------------------------------------
  $('#addActorButton').click(function () {
    $(".actorInput").first().clone(true).appendTo(".actorsContainer");
    return false;
  });

  $('#addDirectorButton').click(function () {
    $(".directorInput").first().clone(true).appendTo(".directorsContainer");
    return false;
  });

  $('#addProducerButton').click(function () {
    $(".producerInput").first().clone(true).appendTo(".producerContainer");
    return false;
  });
  //==========-----------------------------------------------------------------------
  // initialize
  $('.materialSelect').material_select();

  // setup listener for custom event to re-initialize on change
  $('.materialSelect').on('contentChanged', function () {
    $(this).material_select();
  });

  // update function for demo purposes
  $("#myButton").click(function () {

    // add new value
    var newValue = getNewDoggo();
    var $newOpt = $("<option>").attr("value", newValue).text(newValue)
    $("#myDropdown").append($newOpt);

    // fire custom event anytime you've updated select
    $("#myDropdown").trigger('contentChanged');

  });

  $(document).ready(function () {
    M.updateTextFields();
  });

})