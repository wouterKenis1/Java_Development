let notes = [{
        title: "My next trip",
        body: "I would like to go to Spain",
    },
    {
        title: "Habbits to work on",
        body: "Exercise. eating a bit better",
    },
    {
        title: "Office modification",
        body: "Get a new seat",
    },
];
//
//const findNote = function(notes, noteTitle){
//    const index =  notes.findIndex(function(note, index){
//        return note.title.toLowerCase() === noteTitle.toLowerCase();
//    });
//    return notes[index];
//}

const findNote = function(notes, noteTitle){
    return notes.find(function(note, index){
        return note.title.toLowerCase() === noteTitle.toLowerCase();
    });

}

const note = findNote(notes,"office modification")
console.log(note);

console.log("-----  -----")
notes = [{
        title: "My next trip",
        body: "I would like to go to Spain",
    },
    {
        title: "Habbits to work on",
        body: "Exercise. eating a bit better",
    },
    {
        title: "Office modification",
        body: "Get a new seat",
    },
];

const findNotes = function(notes,query){
    return notes.filter(function(note,index){
        const isTitleMatch = note.title.toLowerCase().includes(query.toLowerCase());
        const isBodyMatch = note.body.toLowerCase().includes(query.toLowerCase());
        return (isTitleMatch || isBodyMatch);
    })
}

console.log(findNotes(notes,"eating"));

console.log("-----  -----");
notes = [{
        title: "My next trip",
        body: "I would like to go to Spain",
    },
    {
        title: "Habbits to work on",
        body: "Exercise. eating a bit better",
    },
    {
        title: "Office modification",
        body: "Get a new seat",
    },
];
const sortNotes = function(notes){
    notes.sort(function(a,b){
        if(a.title.toLowerCase() < b.title.toLowerCase()){ return -1;}
        if(a.title.toLowerCase() > b.title.toLowerCase()){ return 1;}
        else{ return 0;}
    })
}

console.log(notes);
sortNotes(notes);
console.log(notes);

