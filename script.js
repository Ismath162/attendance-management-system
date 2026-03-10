const api = "http://localhost:8080/api/attendance";

window.onload = loadAttendance;

async function loadAttendance(){

const response = await fetch(api);

const data = await response.json();

displayData(data);

}

function displayData(data){

const table = document.getElementById("attendanceTable");

table.innerHTML = "";

data.forEach(a => {

const statusCheck = a.status.toLowerCase().trim() === "absent";

let style = statusCheck
? 'background-color:#ffcccc;color:#a10000;font-weight:bold;'
: '';

let row = `<tr>
<td style="${style}">${a.attendanceId}</td>
<td style="${style}">${a.studentName}</td>
<td style="${style}">${a.rollNumber}</td>
<td style="${style}">${a.courseName}</td>
<td style="${style}">${a.attendanceDate}</td>
<td style="${style}">${a.status}</td>
<td style="${style}">
<button class="btn btn-warning btn-sm" onclick="updateAttendance(${a.attendanceId})">Update</button>
<button class="btn btn-danger btn-sm" onclick="deleteAttendance(${a.attendanceId})">Delete</button>
</td>
</tr>`;

table.innerHTML += row;

});

}

async function addAttendance(){

const studentName = document.getElementById("studentName").value;
const rollNumber = document.getElementById("rollNumber").value;
const courseName = document.getElementById("courseName").value;
const attendanceDate = document.getElementById("attendanceDate").value;
const status = document.getElementById("status").value;

if(!studentName || !rollNumber || !attendanceDate){

alert("Required fields missing");
return;

}

await fetch(api,{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
studentName,
rollNumber,
courseName,
attendanceDate,
status
})

});

loadAttendance();

}

async function deleteAttendance(id){

await fetch(api + "/" + id,{
method:"DELETE"
});

loadAttendance();

}

async function updateAttendance(id){

const studentName = prompt("Enter student name");
const rollNumber = prompt("Enter roll number");
const courseName = prompt("Enter course name");
const attendanceDate = prompt("Enter attendance date (YYYY-MM-DD)");
const status = prompt("Enter status (Present/Absent)");

if(!studentName || !rollNumber || !attendanceDate){

alert("Required fields missing");
return;

}

await fetch(api + "/" + id,{

method:"PUT",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
studentName,
rollNumber,
courseName,
attendanceDate,
status
})

});

loadAttendance();

}

async function searchAttendance(){

const name = document.getElementById("searchBox").value;

const response = await fetch(api + "/search/" + name);

const data = await response.json();

displayData(data);

}

async function filterStatus(){

const status = document.getElementById("filterStatus").value;

if(status===""){
loadAttendance();
return;
}

const response = await fetch(api + "/status/" + status);

const data = await response.json();

displayData(data);

}