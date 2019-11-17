define(["require", "exports", "greeter"], function (require, exports, model) {
    "use strict";
    exports.__esModule = true;
    var el = document.getElementById('content');
    var greeter = new model.Greeter(el);
    greeter.start();
});
//# sourceMappingURL=app.js.map