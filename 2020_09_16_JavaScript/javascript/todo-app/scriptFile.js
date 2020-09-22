let todos = [];
const filters = {
searchText: "",
}
let hideCompleted = false;

todos = getSavedTodos();
renderTodos(todos,filters);



// todo-text-search button
document.querySelector("#todo-text-search").addEventListener("input",function(e){
    filters.searchText = e.target.value;
    renderTodos(todos,filters);
});


document.querySelector("#todo-create-form").addEventListener("submit", function(e){
    e.preventDefault();
    todo = {
        id: uuidv4(),
        text: e.target.elements.todoText.value,
        completed: false,
    };
    todos.push(todo);

    setSavedTodos(todos);

    renderTodos(todos,filters);
    e.target.elements.todoText.value = "";
});


document.querySelector("#todo-checkbox-completed").addEventListener("change",function(e){
    hideCompleted = e.target.checked;
    renderTodos(todos,filters);
})



