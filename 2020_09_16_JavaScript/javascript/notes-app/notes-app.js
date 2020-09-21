// DOM = Document Object Model

const notes = [{
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

const filters = {
    searchText: "",
};

const renderNotes = function(notes,filters){
    const filteredNotes = notes.filter(function(note){
        return note.title.toLowerCase().includes(filters.searchText.toLowerCase());
    });
    console.log(filteredNotes);
    document.querySelector("#notes").innerHTML = ""; // clear div<id="notes"> </div>

    filteredNotes.forEach(function (note){
        const noteElement = document.createElement("p");
        noteElement.textContent = note.title;
        document.querySelector("#notes").appendChild(noteElement);
    })
};

const logNewNote = function(){
    console.log(document.querySelector("#text-create"));
};

renderNotes(notes,filters);


// Query and remove
// const p = document.querySelector("p");
// p.remove();

// Query all and remove
//const ps = document.querySelectorAll("p");

//ps.forEach(function(p){
//    p.textContent = "******";
////    console.log(p.textContent);
////    p.remove();
//});

//// add new element
//const newParagraph = document.createElement("p");
//newParagraph.textContent = "This is a new element from JavaScript";
//document.querySelector("body").appendChild(newParagraph);

//document.querySelector("button").addEventListener("click",function(e){
//    console.log("Did this work?");
//    console.log(e);
//    e.target.textContent = "The button was clicked";
//});

document.querySelector("#create-note").addEventListener("click",function(e){
    console.log("Did this work?");
    console.log(e);
    e.target.textContent = "The button was clicked";
});
document.querySelector("#remove-all").addEventListener("click",function(e){
    document.querySelectorAll(".note").forEach(function(note){
        note.remove();
    });
});

document.querySelector("#text-search").addEventListener("input",function(e){
    filters.searchText = e.target.value;
    renderNotes(notes,filters);
});

document.querySelector("#text-create").addEventListener("input",function(e){
    console.log(e);
    logNewNote();
});
