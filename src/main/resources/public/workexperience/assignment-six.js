var data = {
    name : "Jantje Beton"
};

$(function () {
    var jsonString = JSON.stringify(data);

    $.ajax({
        url: "/work-experience",
        type: "POST",
        data: jsonString,
        contentType: "application/json",
        success: function() {
            getDataAndFillTables();
        }
    });
});

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