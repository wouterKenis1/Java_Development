todos = [
    {
        text: "order cat food",
        completed: true,
    },
    {
        text: "clean the kitchen",
        completed: false,
    },
    {
        text: "buy food",
        completed: false,
    },
    {
        text:  "do work",
        completed: true,
    },
    {
        text:  "exercise",
        completed: false,
    },
]
const filters = {
searchText: "",

}
let hideCompleted = false;

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
}
    // clear the div element
    document.querySelector("#todos").innerHTML = "";
    // div element << you have x todos left
    const p = document.createElement("p");
    p.textContent = `you have ${incompleteTodos.length} todos left.`;
    document.querySelector("#todos").appendChild(p);
    // div element << todos
    incompleteTodos.forEach(function(todo){
        const paragraph = document.createElement("p");
        paragraph.textContent = todo.text;
        document.querySelector("#todos").appendChild(paragraph);
    });


};
renderTodos(todos,filters);

//leftToDo = todos.filter(function(todo){
//    return !todo.completed;
//
//});
//
//// you have x todos left
//let p = document.createElement("p");
//p.textContent = `you have ${leftToDo.length} todos left`;
//document.querySelector("body").appendChild(p);
//
//// add a p for each todo
//leftToDo.forEach(function(todo,index){
//    let p = document.createElement("p");
//    p.textContent = todo.text;
//    document.querySelector("body").appendChild(p);
//});
//
//// todo-add button
//document.querySelector("#todo-add").addEventListener("click",function(e){
//    console.log("Adding Todo");
//
//});

// todo-text-search button
document.querySelector("#todo-text-search").addEventListener("input",function(e){
    filters.searchText = e.target.value;
    renderTodos(todos,filters);
});
//
//// new-todo-text button
//document.querySelector("#todo-text-new").addEventListener('input',function(e){
//    console.log(e.target.value);
//
//});

// ----- 7-12 -----

// create form w/ todo text
// setup submit handler & cancel default
// add a new item to todos w/ text data
// render app
// clear input field

document.querySelector("#todo-create-form").addEventListener("submit", function(e){
    e.preventDefault();
    todo = {
         text: e.target.elements.todoText.value,
         completed: false,
    };
    todos.push(todo);
    renderTodos(todos,filters);
    e.target.elements.todoText.value = "";
});

// ----- 7-13 -----

// create checkbox w/ listener -> "hide completed"
// create hideCompleted filter
// update hideCompleted on checkbox
// setup renderTodos


document.querySelector("#todo-checkbox-completed").addEventListener("change",function(e){
    hideCompleted = e.target.checked;
    renderTodos(todos,filters);
})






