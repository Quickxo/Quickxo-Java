function quickxoColor() {
	var colorStyle = document.getElementById("logo").className; 

	colorStyle = (colorStyle == "green" ? "black" : "green");
	document.getElementById("logo").className = colorStyle; 
} 