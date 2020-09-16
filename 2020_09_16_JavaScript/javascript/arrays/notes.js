let notes = ["Note 1", "Note 2", "Note 3"];

console.log(notes);
console.log(notes.length);
console.log(notes[notes.length - 1]);


console.log(notes.pop());
notes.push("A New Note");
console.log(notes);

console.log(notes.shift());
console.log(notes);

console.log("----- splice -----");
notes = ["Note 1", "Note 2", "Note 3"];
notes.splice(1,0,"New Note");
console.log(notes);

notes = ["Note 1", "Note 2", "Note 3"];
notes.splice(1,1,"New Note");
console.log(notes);

console.log("----- findIndex -----");
notes = ["Note 1", "Note 2", "Note 3", "Note 4"];
let index = notes.findIndex(function(note,index){
    return note === "Note 3";
    }
)
console.log(index);

