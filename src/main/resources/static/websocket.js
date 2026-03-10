var ws;

function connect() {
    var username = document.getElementById("username").value;
    var url = "ws://localhost:8080/chat/" + username;
    ws = new WebSocket(url);

    ws.onmessage = function(event) {
        var log = document.getElementById("log");
        log.value += event.data + "\n";
    };

    ws.onopen = function(event) {
        var log = document.getElementById("log");
        log.value += "Connected as " + username + "\n";
    };

    ws.onclose = function(event) {
        var log = document.getElementById("log");
        log.value += "Disconnected\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    if (ws) ws.send(content);
}
