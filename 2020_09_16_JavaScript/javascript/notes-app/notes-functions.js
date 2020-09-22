


// read notes from localStorage
const getSavedNotes = function(){
    const notesJSON = localStorage.getItem("notes");
    if(notesJSON !== null){
        return JSON.parse(notesJSON);
    }
    else{
        return [];
    }
};

// save notes to localStorage
const setSavedNotes = function(notes){
    localStorage.setItem("notes",notes);
}


// generate DOM structure for a note
const generateNoteDOM = function(note){
    // make container (div)
    const noteEl = document.createElement("div");
    // make text element
    const textEl = document.createElement("span");
    if(note.title.length > 0){
    textEl.textContent = note.title;
    }
    else{
    textEl.textContent = "Unnamed Note";
    }
    // make button element
    const button = document.createElement("button");
    button.textContent = "x";
    // add elements to container
    noteEl.appendChild(button);
    noteEl.appendChild(textEl);
    //return container
    return noteEl;
};

// render application notes
const renderNotes = function(notes,filters){
    const filteredNotes = notes.filter(function(note){
        return note.title.toLowerCase().includes(filters.searchText.toLowerCase());
    });
    console.log(filteredNotes);
    document.querySelector("#notes").innerHTML = ""; // clear div<id="notes"> </div>

    filteredNotes.forEach(function (note){
        const noteElement = generateNoteDOM(note);

        document.querySelector("#notes").appendChild(noteElement);
    })
};


