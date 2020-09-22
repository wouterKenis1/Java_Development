

// localstorage read
const getSavedTodos = function(){
    const todosJSON = localStorage.getItem("todos");

    if(todosJSON !== null){
        return JSON.parse(todosJSON);
    } else{
        return [];
    }
};

// localstorage save
const setSavedTodos = function(todos){
    localStorage.setItem("todos",JSON.stringify(todos));
};

// render app based on filters
const renderTodos = function(todos,filters){
    const incompleteTodos = todos.filter(function(todo){
        return !todo.completed;
    });
    let filteredTodos;
    if(hideCompleted){
        filteredTodos = incompleteTodos.filter(function(todo){
            return todo.text.toLowerCase().includes(filters.searchText.toLowerCase());
        });
    }
    else{
        filteredTodos = todos.filter(function(todo){
            return todo.text.toLowerCase().includes(filters.searchText.toLowerCase());
    });
    //console.log(filteredTodos);
}
    // clear the div element
    document.querySelector("#todos").innerHTML = "";
    // div element << you have x todos left (summary)
    document.querySelector("#todos").appendChild(generateSummaryDOM(incompleteTodos));
    // div element << todos
    filteredTodos.forEach(function(todo){
        document.querySelector("#todos").appendChild(generateTodeDOM(todo));
    });


};

// get DOM elements for an individual note
const generateTodeDOM = function(todo){
    // div container
    const container = document.createElement("div");
    // input checkbox
    const checkbox = document.createElement("input");
    checkbox.setAttribute("type","checkbox");
    // span text
    const text = document.createElement("span");
    text.textContent = todo.text;
    // button
    const button = document.createElement("button");
    button.textContent = "x";
    // fill container
    container.appendChild(checkbox);
    container.appendChild(text);
    container.appendChild(button);
    return container;
};

// get DOM elements for list summary
const generateSummaryDOM = function(incompleteTodos){
    const summary = document.createElement("h2");
    summary.textContent = `you have ${incompleteTodos.length} todos left.`;
    return summary;
};


