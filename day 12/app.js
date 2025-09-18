document.getElementById("fetchBtn").addEventListener("click", getMessage);

async function getMessage() {
    try {
        let response = await fetch("http://localhost:8080/api/message");
        if (!response.ok) {
            throw new Error("HTTP error! status: " + response.status);
        }
        let data = await response.text();
        document.getElementById("message").innerText = data;
    } catch (err) {
        document.getElementById("message").innerText = "Error calling backend: " + err;
        console.error(err);
    }
}
