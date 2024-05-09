const togglebtn = document.querySelector(".toggle-btn");
const sidebar = document.querySelector('#sidebar');
togglebtn.addEventListener("click", function () {
  sidebar.classList.toggle("expand");
});

function toggleSidebarClass(x) {
  if (x.matches) { 
    sidebar.classList.remove('expand');
  } else {
    sidebar.classList.add('expand');
  }
}

var x = window.matchMedia("(max-width: 700px)");

toggleSidebarClass(x);

x.addEventListener("change", function() {
  toggleSidebarClass(x);
});

