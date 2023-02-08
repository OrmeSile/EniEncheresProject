const buyGroup = document.querySelectorAll(".buy-group>div>input");
const sellGroup = document.querySelectorAll(".sell-group>div>input");
const achatRadio = document.querySelector('#buy');
const venteRadio = document.querySelector('#sell');


achatRadio.addEventListener('click', () => {
    buyGroup.forEach(x => x.disabled = false)
    sellGroup.forEach(x=> x.disabled = true)
})
venteRadio.addEventListener('click', () => {
    buyGroup.forEach(x => x.disabled = true)
    sellGroup.forEach(x => x.disabled = false)
})
