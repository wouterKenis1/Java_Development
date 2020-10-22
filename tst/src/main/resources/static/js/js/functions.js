
const setFirstElements = function(){
    elements = [
        {
        id:1,
        name:"Water",
        },
        {
            id:2,
            name:"Fire"
        },
        {
            id:3,
            name:"Earth"
        },
        {
            id:4,
            name:"Air"
        }
    ]
    setSavedElements(elements);
}

const getElementsFromDatabaseElement = function(){
    let databaseData = document.getElementsByName("databaseData");
    let databaseElements = [{}]
    for(var x = 0; x < databaseData.length;x++){
        databaseRow = databaseData.item(x);
        dataId = databaseRow.children.item(0)
        dataName = databaseRow.children.item(1)
        //console.log("id:" + dataId.textContent + "\tname:" + dataName.textContent);
        elements.push({
            id: dataId.textContent,
            name: dataName.textContent,});
    }
    setSavedElements(elements)
}

let element1 = elements[0];
let element2 = elements[0];

const getSavedElements = function(){
    const elementsJSON = localStorage.getItem("elements");
    if(elementsJSON != null){
        return JSON.parse(elementsJSON);
    }
    else{
        return [];
    }
};

const setSavedElements = function(elements){
    localStorage.setItem("elements", JSON.stringify(elements));
    console.log("elements saved");
};

const clearSavedAll = function(){
    localStorage.clear()
    console.log("elements cleared");
};

const generateElementDOM = function(element){
    const objEl = document.createElement("div");
    const objText = document.createElement("span");
    const objRadio1 = document.createElement("input");
    const objRadio2 = document.createElement("input");

    if(element.name.length > 0){
        objText.textContent = element.id + ": " + element.name;
    }
    else{
        objText.textContent = element.id + ": --unnamed element--";
    }

    objRadio1.setAttribute("type", "radio");
    objRadio2.setAttribute("type", "radio");
    objRadio1.setAttribute("name", "try1");
    objRadio2.setAttribute("name", "try2");

    objRadio1.addEventListener("click", function(){
        element1 = element;
        renderElement1();
    });
    objRadio2.addEventListener("click", function(){
        element2 = element;
        renderElement2();
    });


    objEl.appendChild(objRadio1);
    objEl.appendChild(objRadio2);
    objEl.appendChild(objText);
    return objEl;
};

const renderElements = function(elements){
    //console.log(elements);
    document.querySelector("#elements").innerHTML = "";
    elements.forEach(function (element){
        const objEl = generateElementDOM(element);
        document.querySelector("#elements").appendChild(objEl);

    })
};

const generateSpanElement1 = function(){
    const objText = document.createElement("span");
    objText.setAttribute("value",element1.name);
    return objText;
}

const renderElement1 = function(){
    document.querySelector("#element1").innerHTML = generateSpanElement1().getAttribute("value");
    //console.log("el1 rendered");
    //console.log(document.getElementById("FormElement1"));
    document.getElementById("FormElement1").setAttribute("value",element1.name);
}

const generateSpanElement2 = function(){
    const objText = document.createElement("span");
    objText.setAttribute("value",element2.name);
    return objText;
}

const renderElement2 = function(){
    document.querySelector("#element2").innerHTML = generateSpanElement2().getAttribute("value");
    //console.log("element2 rendered");
    //console.log(document.getElementById("FormElement2"));
    document.getElementById("FormElement2").setAttribute("value",element2.name);
}




