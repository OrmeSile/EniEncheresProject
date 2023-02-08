const buyGroup = document.querySelectorAll(".buy-group>div>input");
const sellGroup = document.querySelectorAll(".sell-group>div>input");
const achatRadio = document.querySelector('#buy');
const venteRadio = document.querySelector('#sell');
achatRadio.addEventListener('click', () => {
    buyGroup.forEach((x,key) => {
        x.disabled = false;
        key === 0 ? x.checked = true : x.checked = false;
    })
    sellGroup.forEach(x=>{
        x.disabled = true
        x.checked = false
    })
})
venteRadio.addEventListener('click', () => {
    buyGroup.forEach((x, key) => {
        x.disabled = true
        x.checked = false
    })
    sellGroup.forEach((x, key) => {
        x.disabled = false
        key === 0 ? x.checked = true : x.checked = false
    })
})
