document.addEventListener("DOMContentLoaded", () => {
  const btn = document.getElementById("botondemo");
  const out = document.getElementById("demooutput");
  let marco = true;

  if (!btn || !out) return;

  btn.addEventListener("click", () => {
    if (marco) {
      out.textContent = "¡Polo!";
      btn.textContent = "¡Marco!";
    } else {
      out.textContent = "¡Marco!";
      btn.textContent = "¡Polo!";
    }
    marco = !marco;
  });
});
