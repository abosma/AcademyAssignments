let exampleModal = $('#exampleModal');
let dataTable = $('#workExperiences');

// Voeg een dummy Jantje Beton object toe
$(function () {
    let data = {
        name : "Jantje Beton"
    };
    let jsonString = JSON.stringify(data);

    $.ajax({
        url: "/work-experience",
        type: "POST",
        data: jsonString,
        contentType: "application/json",
        success: function() {
            // Initializeer de datatable nadat de dummy data is toegevoegd
            fillDataTable(dataTable);
        }
    });
});

function fillDataTable(toUpdateObject)
{
    // De datatable wordt gevuld met de data van /work-experiences. Het json array heeft geen naam, dus is dataSrc : ''.
    // De kolommen van het WorkExperience object worden hier aangegeven, het aantal tabel-rows moeten hetzelfde zijn als de aangegeven kolommen.
    toUpdateObject.DataTable({
        ajax: {
            url: '/work-experiences',
            dataSrc: ''
        },
        columns: [
            { data: 'id' },
            { data: 'name' },
            { data: 'startingYear' },
            { data: 'endingYear' },
            { data: 'startingMonth' },
            { data: 'endingMonth' }
        ]
    });
}

// Wanneer er op de modal create button gedrukt wordt
$('#createButton').on('click', function() {
    postDataAndRefreshForm()
})

function postDataAndRefreshForm()
{
    // Haal alle ingevulde informatie op, en zet het in een JSON object
    let inputName = $("#nameInput").val();
    let inputStartYear = $("#startYearInput").val();
    let inputEndYear = $("#endYearInput").val();
    let inputStartMonth = $("#startMonthInput").val();
    let inputEndMonth = $("#endMonthInput").val();

    let toInsertWorkExperience = {
        id : '',
        name : inputName,
        startingYear : inputStartYear,
        endingYear : inputEndYear,
        startingMonth : inputStartMonth,
        endingMonth : inputEndMonth
    }

    // Zet het JSON object om naar een JSON string dat de back-end kan gebruiken
    let jsonString = JSON.stringify(toInsertWorkExperience);

    // Stuur het JSON object op naar de POST mapping /work-experience
    $.ajax({
        url: "/work-experience",
        type: "POST",
        data: jsonString,
        contentType: "application/json",
        success: function() {
            // Herlaad de datatable. De datatable weet al van de initializatie waar hij moet zoeken voor nieuwe informatie.
            dataTable.DataTable().ajax.reload();
        }
    });

    exampleModal.modal('toggle')
}


// Assignment Zes, andere manier van het aanvullen van tabeldata.
function getDataAndFillTables()
{
    $.ajax({
        url: "/work-experiences",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        success: function(data) {
            for(var i = 0; i < data.length; i++)
            {
                var workExperience = data[i]
                var nameElement = `<li> ${workExperience.name} </li>`;
                var startingYearElement = `<li> ${workExperience.startingYear} </li>`;
                var startingMonthElement = `<li> ${workExperience.endingYear} </li>`;
                var endingYearElement = `<li> ${workExperience.startingMonth} </li>`;
                var endingMonthElement = `<li> ${workExperience.endingMonth} </li>`;

                $("#workExperiences").append(nameElement, startingYearElement, startingMonthElement, endingYearElement, endingMonthElement);
            }
        }
    })
}