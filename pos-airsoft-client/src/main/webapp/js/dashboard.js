var NOT_ACCEPTABLE = "406";
var OK = "200";
var CURR_PAGE;

function processing() {
    $(".loading").show();
}

function processDone() {
    $(".loading").hide();
}

function loadGameRegister() {
    processing();
    $.ajax({
        url: "/game",
        type: 'GET',
        context: document.body
    }).done(function (data) {
        loadSection(data);
    });
}

function loadGamePage() {
    processing();
    $.ajax({
        url: "/game/games",
        type: 'GET',
        context: document.body
    }).done(function (data) {
        loadSection(data);
    });
}

function loadPlayerRegister() {
    processing();
    $.ajax({
        url: "/player",
        type: 'GET',
        context: document.body
    }).done(function (data) {
        loadSection(data);
    });
}

function loadAllGames() {
    $.ajax({
        url: "/game/all",
        type: 'GET',
        context: document.body
    }).done(function (data) {
        loadSection(data);
    });
}

function loadFinishedGames(pageNumber) {
    $.ajax({
        url: "/game/finished/page/" + pageNumber,
        type: 'GET',
        context: document.body
    }).done(function (data) {
        loadSection(data);
    });
}

function viewGame(id) {
    $.ajax({
        url: "/game/view/" + id,
        type: 'POST',
        context: document.body
    }).done(function (data) {
        loadModal(data);
    });
}

function loadSection(data) {
    var contentWrapper = $(".content-wrapper");
    contentWrapper.empty();
    contentWrapper.append(data);
    processDone();
}

function loadModal(data) {
    var contentWrapper = $(".modal-wrapper");
    contentWrapper.empty();
    contentWrapper.append(data);
}


function saveGame() {
    var formData = new FormData();
    $("#new-game").find("input").each(function () {
        formData.append($(this)[0].name, $(this)[0].value);
    });
    formData.append("plot", $('#plot').val());
    formData.append("thematicImage", $('#file')[0].files[0]);
    submitFormAjax("new-game", "/game/new", formData);
}

function savePlayer() {
    var formData = new FormData();
    $("#new-player").find("input").each(function () {
        formData.append($(this)[0].name, $(this)[0].value);
    });
    submitFormAjax("new-player", "/player/new", formData);
}

function cancelGame(id) {
    $.ajax({
        url: "/game/cancel/" + id,
        type: 'POST',
        context: document.body
    }).done(function () {
        loadAllGames();
    });
}
function finishGame(id) {
    $.ajax({
        url: "/game/finish/" + id,
        type: 'POST',
        context: document.body
    }).done(function () {
        loadAllGames();
    });
}

function submitFormAjax(form, action, formData) {

    $.ajax({
        url: action,
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        beforeSend: function () {
            $(".overlay").show();
        },
        complete: function () {
            $(".overlay").hide();
        },
        success: function (data) {
            processResult(form, data);
        },
        error: function (e) {
            console.log(e);
        }

    });
}

function processResult(form, data) {
    if (data === OK) {
        clearForm(form);
        alertMsg(form, "success", "Salvo!");
    } else {
        alertMsg(form, "danger", "Erro!");
    }
}

function clearForm(form) {
    $("#" + form).find("input").each(function () {
        $(this).val("");
    });
    $("#" + form).find("textarea").each(function () {
        $(this).val("");
    });
}

function alertMsg(form, type, msg) {
    $("#" + form).parent().first().prepend("<div class='alert-dismiss pad'><br><div class='alert alert-" + type + " alert-dismissible'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><h4> Operação </h4>" + msg + "</div></div>");
    $(".alert-dismiss").delay(3000).fadeOut();
}

function nextPage() {
    loadFinishedGames(parseInt(CURR_PAGE) + 1);
}

function prevPage() {
    if (CURR_PAGE > 1) {
        loadFinishedGames(parseInt(CURR_PAGE) - 1);
    }
}

function sendAlbum(id) {
    var formData = new FormData();
    formData.append("name", $("#name").val());
    var files = $("#files")[0].files;
    for (var i = 0, max = files.length; i < max; i++) {
        formData.append("files", files[i]);
    }
    formData.append("gameId", id);
    submitFormAjax("album", "/game/album/send", formData);
    $('#modal').on('hidden.bs.modal', function (e) {
        loadFinishedGames(CURR_PAGE);
    });
}