function Coordinate(distance, count) {
    this.distance = distance;
    this.w = document.body.clientWidth;
    this.h = document.body.clientHeight;
    this.maxX = Math.floor(this.w / this.distance) / 2;
    this.maxY = Math.floor(this.h / this.distance) / 2;
    if (count === void 0) count = Math.ceil(this.w / distance);

    this.drawAxis(-this.maxX, 0, this.w, this.HORIZONTAL);
    this.drawAxis(0, this.maxY, this.h, this.VERTICAL);

    for (var i=1; i<=count; i++) {
        this.drawAxis(i, 0, this.h, this.VERTICAL, "rgb(0, 0, 0, 0.3)");
        this.drawAxis(-i, 0, this.h, this.VERTICAL, "rgb(0, 0, 0, 0.3)");
        this.drawAxis(0, i, this.w, this.HORIZONTAL, "rgb(0, 0, 0, 0.3)");
        this.drawAxis(0, -i, this.w, this.HORIZONTAL, "rgb(0, 0, 0, 0.3)");
    }
}

Coordinate.prototype.drawRect = function (x0, y0, x1, y1, bc) {
    if (bc === void 0) bc = "rgb(" + (Math.floor(Math.random() * 255)) + ", " + (Math.floor(Math.random() * 255)) + ", " + (Math.floor(Math.random() * 255)) + ")";
    var minX = Math.min(x0, x1), maxY = Math.max(y0, y1), w = Math.abs(x1 - x0), h = Math.abs(y1 - y0);

    var rect = document.createElement("div");
    rect.style.position = "absolute";
    rect.style.left = (this.centerX + minX * this.distance) + "px";
    rect.style.top = (this.centerY - maxY * this.distance) + "px";
    rect.style.width = w * this.distance + "px";
    rect.style.height = h * this.distance + "px";
    rect.style.backgroundColor = bc;
    rect.style.borderStyle = "solid";
    rect.style.borderColor = "#000000";
    rect.addEventListener("mouseover", function() {this.style.borderWidth = "1px";}.bind(rect));
    rect.addEventListener("mouseout", function() {this.style.borderWidth = "0";}.bind(rect));
    document.querySelector("#coordinate").appendChild(rect);
};

Coordinate.prototype.drawAxis = function (x, y, width, direction, color) {
    if (direction === void 0) direction = this.HORIZONTAL;
    if (width === void 0) width = direction === this.HORIZONTAL ? this.w : this.h;
    if (color === void 0) color = "#000000";

    var line = document.createElement("div");
    line.style.position = "absolute";
    line.style.left = (direction === this.HORIZONTAL ? 0 : (this.centerX + x * this.distance)) + "px";
    line.style.top = (direction === this.VERTICAL ? 0 : (this.centerY - y * this.distance)) + "px";
    line.style.width = direction === this.HORIZONTAL ? width + "px" : "1px";
    line.style.height = direction === this.VERTICAL ? width + "px" : "1px";
    line.style.backgroundColor = color;
    document.querySelector("#coordinate").appendChild(line);
};

Object.defineProperty(Coordinate.prototype, "HORIZONTAL", {
    value: "horizontal",
    writable: false
});

Object.defineProperty(Coordinate.prototype, "VERTICAL", {
    value: "vertical",
    writable: false
});

Object.defineProperty(Coordinate.prototype, "centerX", {
    get: function () {
        return this.w / 2;
    }
});

Object.defineProperty(Coordinate.prototype, "centerY", {
    get: function () {
        return this.h / 2;
    }
});