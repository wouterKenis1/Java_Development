// DOM = Document Object Model



const notes = getSavedNotes();

const filters = {
    searchText: "",
};

const logNewNote = function(){
    console.log(document.querySelector("#text-create"));
};

renderNotes(notes,filters);

document.querySelector("#create-note").addEventListener("click",function(e){
    notes.push({
        id: uuidv4(),
        title: "",
        body: "",
    });
    localStorage.setItem("notes", JSON.stringify(notes));
    renderNotes(notes,filters);
});

document.querySelector("#text-search").addEventListener("input",function(e){
    filters.searchText = e.target.value;
    renderNotes(notes,filters);
});

document.querySelector("#for-fun").addEventListener("change",function(e){
    console.log(e.target.checked);

});

document.querySelector("#filter-by").addEventListener("change",function(e){
    console.log(e.target.value);
});

