function copyValue(button) {

    let icon = button.querySelector('i');



    icon.setAttribute('class', 'bi bi-clipboard-check-fill ms-3 text-white');  //change icon

    var valueToCopy = button.value; // get the value of the clicked button

    navigator.clipboard.writeText(valueToCopy)


    setTimeout(() => {
        icon.setAttribute('class', 'bi bi-clipboard ms-3 text-white');  //change icon

    }, 1000);

}




//--------------------------------------------------------------------------


const data = [
    {
        UserID: 1,
        LiveUrl: "http/localhost:3306/",
        CreatedAt: "25 May",
        UpdatedAt: "30 May",
        status: "Success"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3307/",
        CreatedAt: "2 May",
        UpdatedAt: "3 May",
        status: "Stop"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3309/",
        CreatedAt: "15 May",
        UpdatedAt: "30 May",
        status: "Success"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3310/",
        CreatedAt: "21 May",
        UpdatedAt: "25 May",
        status: "Stop"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3311/",
        CreatedAt: "16 April",
        UpdatedAt: "25 April",
        status: "stop"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3312/",
        CreatedAt: "18 May",
        UpdatedAt: "19 May",
        status: "Success"
    },
    {
        UserID: 1,
        LiveUrl: "http/localhost:3313/",
        CreatedAt: "9 May",
        UpdatedAt: "30 May",
        status: "Success"
    }
];

const renderData = (data, text = null) => {
    let tempData = [];
    if (text) {
        text = text.toLowerCase().trim()
        let regex = new RegExp(text?.toLowerCase());
        for (let eachData of data) {
            if (eachData?.status?.toLowerCase().includes(text)) {
                tempData.push(eachData)
            }
        }
    } else {
        tempData = data;
    }

    const tableBody = document.getElementById("table-body");
    tableBody.innerHTML = "";
    for (let row of tempData) {
        let start = (row.status.toLowerCase() === 'success') ? 'disabled' : '';
        let stop = (row.status.toLowerCase() === 'stop') ? 'disabled' : '';
        tableBody.innerHTML += `
                <tr>
                <th scope="row">${row.UserID}</th>
                <td> <a class="link"
                href="${row.LiveUrl}">${row.LiveUrl}</a><button
                value="${row.LiveUrl}"
                onclick="copyValue(this)" class="btn btn-border"><i
                class="bi bi-clipboard ms-3 text-white"></i></button>
                </td>
                <td>${row.CreatedAt}</td>
                <td>${row.UpdatedAt}</td>
                <td>${row.status}</td>
                   <td>
                <div class="d-flex justify-content-around">
                <button class="btn btn-border" ${start}><i class="bi bi-power text-white fs-1"></i></button>
                <button class="btn btn-border" ${stop}><i class="bi bi-sign-stop-fill text-white fs-1"></i></button>
                <button class="btn btn-border" onclick="deleteRow('${row.LiveUrl}')"><i class="bi bi-trash2-fill text-white fs-1"></i></button>
                </div>
                </td>
                <td> <span> <a class="link"> view Logs</a></td>
                </tr>
                `;
    }
}

renderData(data);

const search = () => {
    const searchValue = document.getElementById("Search-deploy")?.value;
    renderData(data, searchValue);
}


const deleteRow = (liveUrl) => {

    const index = data.findIndex(item => item.LiveUrl === liveUrl);

    if (index !== -1) {

        data.splice(index, 1);


        renderData(data);
    }
};