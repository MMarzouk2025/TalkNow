<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Talk-Now</title>
    </head>
    <body style="background: cyan;">
        <div id="wrapper" style="overflow: hidden;">
            <div id="leftArea" style="float: left; width: 80%;">
                <div id="messagesArea" style="padding: 2%">
                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>

                    <div>
                        <span>Ahmed Tarik: </span>
                        <span>Hello all !!</span>
                    </div>
                </div>
                
                <div style="border: solid blue 1px; border-radius: 20px; padding: 10px; width: 20%;">
                    <input type="text" id="msgTxt" name="message">
                    <button id="sendBtn" onclick="sendMessage()">Send</button>
                </div>
            </div>

            <div id="rightArea">
                <table id="usersTable" border="0" style="float: right; padding: 2%; overflow: hidden;">
                    <tr>
                        <td>Ahmed Tarik</td>
                        <!-- <td>online</td> -->
                    </tr>
                    <tr>
                        <td>Hossam Mohamed</td>
                    </tr>
                    <tr>
                        <td>Aya Hussein</td>
                    </tr>
                </table>
            </div>
        </div>

        <script src="../jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
                            function sendMessage() {
                                var user = "Marzouk"
                                var msg = $("#msgTxt").val();
                                $.post("../chat", {
                                    "action": "message",
                                    "user": user,
                                    "msg": msg
                                });
                                $("#msgTxt").val("");
                            }
                            setInterval(function () {
                                $.get("../chat", function (response, status, xhr) {
                                    if (status === "success") {
                                        var messagesObject = JSON.parse(response);
                                        var msgs = "";
                                        for (i = 0; i < messagesObject.length; i++) {
                                            var sender = messagesObject[i].sender;
                                            var messageContent = messagesObject[i].messageContent;
                                            msgs += "<div><span>" + sender + ": </span><span>" + messageContent + "</span></div>";
                                        }
                                        $("#messagesArea").html(msgs);
                                    }
                                }
                                )
                            }, 100);
        </script>
    </body>
</html>
