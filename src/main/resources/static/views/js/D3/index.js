 // javascript
var dataset = [80, 100, 56, 120, 180, 30, 40, 120, 160,80, 100, 56, 120, 180, 30, 40, 120, 160,80, 100, 56, 120, 180, 30, 40, 120, 160];

var svgWidth = 1000, svgHeight = 500, barPadding = 5;
var barWidth = (svgWidth /7);
var earningbarcolor=#69b3a2";


var svg = d3.select('svg')
    .attr("width", svgWidth)
    .attr("height", svgHeight);
    
var barChart = svg.selectAll("rect")
    .data(dataset)
    .enter()
    .append("rect")
    .attr("y", function(d) {
         return svgHeight - d 
    })
    .attr("height", function(d) { 
        return d; 
    })
    .attr("width", barWidth - barPadding)
    .attr("transform", function (d, i) {
        var translate = [barWidth * i, 0]; 
        return "translate("+ translate +")";
    });
    function generateAlert(){
    	alert("Helo");
    }
    generateAlert();
