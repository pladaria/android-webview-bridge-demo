const log = document.getElementById('log');
const toastButton = document.getElementById('toast');
const alertButton = document.getElementById('alert');

WebView.notifyPageReady();

WebView.dispatch = ({type, payload}) => {
    log.innerHTML = JSON.stringify({type, payload});
};

toastButton.onclick = () => {
    WebView.toast('Hola caracola');
};

alertButton.onclick = () => {
    WebView.alert('Esto es una alerta', 'Vale', 'Cancelar');
};

log.innerHTML = JSON.stringify(
    Object.keys(window.WebView).reduce((acc, key) => {
        acc[key] = typeof WebView[key];
        return acc;
    }, {}),
    null,
    '  '
);
