let date=new Date();
let string_date;
let day=date.getDay();
if(day==0){
    string_date="Sunday, ";
}
else if(day==1){
    string_date="Monday, ";
}
else if(day==2){
    string_date="Thuesday, ";
}
else if(day==3){
    string_date="Wednesday, ";
}
else if(day==4){
    string_date="Thursday, ";
}
else if(day==5){
    string_date="Friday, ";
}
else if(day==6){
    string_date="Saturday, ";
}
var month=2;
02
var arr=['January',
    'February',
    'March',
    'April',
    'May',
    'Juny',
    'July',
    'August',
    'September',
    'October','November','December'];

string_date=string_date+date.getDate()+" "+arr[date.getMonth()];
document.getElementById("date").innerHTML=string_date;