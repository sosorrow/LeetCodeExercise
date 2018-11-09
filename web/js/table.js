var Table = function (c, l, size) {
    var count = document.querySelector(".tables") || 0;
    if (count) count = count.length;

    this.instance = document.createElement("table");
    this.instance.setAttribute("id", "table-" + count);
    this.instance.setAttribute("class", "tables");

    this.instance.style.position = "absolute";
    this.instance.style.borderWidth = "1px";
    this.instance.style.left = (document.body.clientWidth - size * c) / 2 + "px";
    this.instance.style.top = (document.body.clientHeight - size * l) / 2 + "px";

    for (var i = 0; i < l; i++) {
        var tr = document.createElement("tr");
        tr.style.height = size + "px";
        this.instance.appendChild(tr);

        for (var j = 0; j < c; j++) {
            var td = document.createElement("td");
            td.style.width = size + "px";
            if (j < c - 1) td.style.borderRightWidth = "1px";
            if (i < l - 1) td.style.borderBottomWidth = "1px";
            tr.appendChild(td);
        }
    }

    document.body.appendChild(this.instance);
};

Table.prototype.fill = function (array) {
    if (!array instanceof Array) return false;
    for (var i = 0; i < array.length; i++) {
        if (array[i] instanceof Array) {
            for (var j = 0; j < array[i].length; j++) {
                this.instance.children[i].children[j].innerHTML = array[i][j];
            }
        } else {
            this.instance.children[0].children[i].innerHTML = array[i];
        }
    }
};

Table.prototype.fillEmpty = function (element) {
    for (var i in this.instance.children) {
        for (var j in this.instance.children[i].children) {
            if (this.instance.children[i].children[j].innerHTML === " ") {
                this.instance.children[i].children[j].innerHTML = element;
            }
        }
    }
};

Table.prototype.set = function (x, y, val) {
    this.instance.children[x].children[y].innerHTML = val;
};