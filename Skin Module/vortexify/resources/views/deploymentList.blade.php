<x-layout :title="'Deployment List'" :logo="asset('Resources/Logo/deployList.svg')">


<section class="color" id="deploylist-section">


        <div class="container-fluid color text-white">
            <div class="row justify-content-center pt-5">
                <div class="col-md-6 mt-6 text-white pt-5">
                    <input class="form-control form-control-lg" type="text" oninput="search()"
                        placeholder="Search by Deployment Status...." id="Search-deploy">
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-12">
                    <section class="intro mt-3" id="table-content">
                        <div class="h-100">
                            <div class="mask d-flex align-items-center h-100">
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-12">
                                            <div class="table-responsive">
                                                <table class="table mb-0">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">User ID</th>
                                                            <th scope="col">Live Url</th>
                                                            <th scope="col">Created At</th>
                                                            <th scope="col">Updated At</th>
                                                            <th scope="col">Status</th>
                                                            <th scope="col">Power ON/ OFF/ Terminate</th>
                                                            <th scope="col">Logs</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody id="table-body">
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                </div>

            </div>

        </div>












    </section>


    @push('listScript')
    <script src="{{asset('Resources/searchPaste.js')}}"> </script>

    @endpush

     <script>

 
function formatDateToDayMonth(isoDateString) {
    const date = new Date(isoDateString);

    const day = date.getDate().toString().padStart(2, '0');
    const month = date.toLocaleString('default', { month: 'short' });

    return `${day} ${month}`;
}


        const data =  @json($data);
 

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
        let start = (row.status.toLowerCase() === 'success'||'start') ? 'disabled' : '';
        let stop = (row.status.toLowerCase() === 'stop') ? 'disabled' : '';
        tableBody.innerHTML += `
                <tr>
                <th scope="row">${row.userId}</th>
                <td> <a class="link"
                href="${row.liveUrl}">${row.liveUrl}</a><button
                value="${row.liveUrl}"
                onclick="copyValue(this)" class="btn btn-border"><i
                class="bi bi-clipboard ms-3 text-white"></i></button>
                </td>
                <td>${formatDateToDayMonth(row.createdAt)}</td>
                <td>${formatDateToDayMonth(row.updatedAt)}</td>
                <td>${row.status}</td>
                   <td>
                <div class="d-flex justify-content-around">
                <button class="btn btn-border" ${start}><i class="bi bi-power text-white fs-1"></i></button>
                <button class="btn btn-border" ${stop}><i class="bi bi-sign-stop-fill text-white fs-1"></i></button>
                <button class="btn btn-border" onclick="deleteRow('${row.liveUrl}')"><i class="bi bi-trash2-fill text-white fs-1"></i></button>
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
        
     </script>



</x-layout>