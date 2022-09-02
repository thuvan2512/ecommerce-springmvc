
function payment(endpoint, context, re) {
    document.getElementById("btn-payment").disabled = true;
    document.getElementById("sp-payment-load").style.display = "block";
    if (confirm("Are you sure you want to create this order?. After you confirm, an email will be sent to you from the system") == true) {
        var type = document.querySelector('input[name="rdPaymentType"]:checked').value;
        fetch(endpoint, {
            method: 'post',
            body: JSON.stringify({
                'paymentType': type,
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            document.getElementById("btn-payment").disabled = false;
            document.getElementById("sp-payment-load").style.display = "none";
            if (data == "OK") {
                alert("Please check your mailbox and reply to us as soon as possible if you have any problem !!!")
                window.location.href = re;
            } else {
                alert("Failed !!!")
            }
        }).catch(err => console.log(err))
    } else {
        document.getElementById("btn-payment").disabled = false;
        document.getElementById("sp-payment-load").style.display = "none";
    }
}