
let elements = getSavedElements();

if(elements.length === 0){
    getElementsFromDatabaseElement();
    console.log("read elements from database")
}
else{
    console.log("found elements");
}

renderElements(elements);

