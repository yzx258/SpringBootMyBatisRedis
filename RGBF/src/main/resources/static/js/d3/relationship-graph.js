!function(root,factory){"use strict";"function"==typeof define&&define.amd?define(["d3"],factory):"object"==typeof module&&module.exports?module.exports=function(d3){return d3.tip=factory(d3),d3.tip}:root.d3.tip=factory(root.d3)}(this,function(d3){"use strict";return function(){function tip(vis){svg=getSVGNode(vis),point=svg.createSVGPoint(),document.body.appendChild(node)}function d3_tip_direction(){return"n"}function d3_tip_offset(){return[0,0]}function d3_tip_html(){return" "}function direction_n(){var bbox=getScreenBBox();return{top:bbox.n.y-node.offsetHeight,left:bbox.n.x-node.offsetWidth/2}}function direction_s(){var bbox=getScreenBBox();return{top:bbox.s.y,left:bbox.s.x-node.offsetWidth/2}}function direction_e(){var bbox=getScreenBBox();return{top:bbox.e.y-node.offsetHeight/2,left:bbox.e.x}}function direction_w(){var bbox=getScreenBBox();return{top:bbox.w.y-node.offsetHeight/2,left:bbox.w.x-node.offsetWidth}}function direction_nw(){var bbox=getScreenBBox();return{top:bbox.nw.y-node.offsetHeight,left:bbox.nw.x-node.offsetWidth}}function direction_ne(){var bbox=getScreenBBox();return{top:bbox.ne.y-node.offsetHeight,left:bbox.ne.x}}function direction_sw(){var bbox=getScreenBBox();return{top:bbox.sw.y,left:bbox.sw.x-node.offsetWidth}}function direction_se(){var bbox=getScreenBBox();return{top:bbox.se.y,left:bbox.e.x}}function initNode(){var node=d3.select(document.createElement("div"));return node.style({position:"absolute",top:0,opacity:0,"pointer-events":"none","box-sizing":"border-box"}),node.node()}function getSVGNode(el){return el=el.node(),"svg"===el.tagName.toLowerCase()?el:el.ownerSVGElement}function getNodeEl(){return null===node&&(node=initNode(),document.body.appendChild(node)),d3.select(node)}function getScreenBBox(){for(var targetel=target||d3.event.target;"undefined"==typeof targetel.getScreenCTM&&"undefined"===targetel.parentNode;)targetel=targetel.parentNode;var bbox={},matrix=targetel.getScreenCTM(),tbbox=targetel.getBBox(),width=tbbox.width,height=tbbox.height,x=tbbox.x,y=tbbox.y;return point.x=x,point.y=y,bbox.nw=point.matrixTransform(matrix),point.x+=width,bbox.ne=point.matrixTransform(matrix),point.y+=height,bbox.se=point.matrixTransform(matrix),point.x-=width,bbox.sw=point.matrixTransform(matrix),point.y-=height/2,bbox.w=point.matrixTransform(matrix),point.x+=width,bbox.e=point.matrixTransform(matrix),point.x-=width/2,point.y-=height/2,bbox.n=point.matrixTransform(matrix),point.y+=height,bbox.s=point.matrixTransform(matrix),bbox}var direction=d3_tip_direction,offset=d3_tip_offset,html=d3_tip_html,node=initNode(),svg=null,point=null,target=null,getPageTopLeft=function(el){var rect=el.getBoundingClientRect(),docEl=document.documentElement;return{top:rect.top+(window.pageYOffset||docEl.scrollTop||0),right:rect.right+(window.pageXOffset||0),bottom:rect.bottom+(window.pageYOffset||0),left:rect.left+(window.pageXOffset||docEl.scrollLeft||0)}};tip.show=function(){var args=Array.prototype.slice.call(arguments);args[args.length-1]instanceof SVGElement&&(target=args.pop());var coords,content=html.apply(this,args),poffset=offset.apply(this,args),dir=direction.apply(this,args),nodel=getNodeEl(),i=directions.length,scrollTop=document.documentElement.scrollTop||document.body.scrollTop,scrollLeft=document.documentElement.scrollLeft||document.body.scrollLeft;nodel.html(content).style({opacity:1,"pointer-events":"all"});var node=nodel[0][0],nodeWidth=node.clientWidth,nodeHeight=node.clientHeight,windowWidth=window.innerWidth,windowHeight=window.innerHeight,elementCoords=getPageTopLeft(this),breaksTop=elementCoords.top-nodeHeight<0,breaksLeft=elementCoords.left-nodeWidth<0,breaksRight=elementCoords.right+nodeHeight>windowWidth,breaksBottom=elementCoords.bottom+nodeHeight>windowHeight;for(breaksTop&&!breaksRight&&!breaksBottom&&breaksLeft?dir="e":!breaksTop||breaksRight||breaksBottom||breaksLeft?breaksTop&&breaksRight&&!breaksBottom&&!breaksLeft?dir="w":breaksTop||breaksRight||breaksBottom||!breaksLeft?!breaksTop&&!breaksRight&&breaksBottom&&breaksLeft?dir="e":breaksTop||breaksRight||!breaksBottom||breaksLeft?!breaksTop&&breaksRight&&breaksBottom&&!breaksLeft?dir="n":breaksTop||!breaksRight||breaksBottom||breaksLeft||(dir="w"):dir="e":dir="e":dir="s",direction(dir);i--;)nodel.classed(directions[i],!1);return coords=direction_callbacks.get(dir).apply(this),nodel.classed(dir,!0).style({top:coords.top+poffset[0]+scrollTop+"px",left:coords.left+poffset[1]+scrollLeft+"px"}),tip},tip.hide=function(){var nodel=getNodeEl();return nodel.style({opacity:0,"pointer-events":"none"}),tip},tip.attr=function(n){if(arguments.length<2&&"string"==typeof n)return getNodeEl().attr(n);var args=Array.prototype.slice.call(arguments);return d3.selection.prototype.attr.apply(getNodeEl(),args),tip},tip.style=function(n,v){if(arguments.length<2&&"string"==typeof n)return getNodeEl().style(n);var args=Array.prototype.slice.call(arguments);return d3.selection.prototype.style.apply(getNodeEl(),args),tip},tip.direction=function(v){return arguments.length?(direction=null==v?v:d3.functor(v),tip):direction},tip.offset=function(v){return arguments.length?(offset=null==v?v:d3.functor(v),tip):offset},tip.html=function(v){return arguments.length?(html=null==v?v:d3.functor(v),tip):html},tip.destroy=function(){return node&&(getNodeEl().remove(),node=null),tip};var direction_callbacks=d3.map({n:direction_n,s:direction_s,e:direction_e,w:direction_w,nw:direction_nw,ne:direction_ne,sw:direction_sw,se:direction_se}),directions=direction_callbacks.keys();return tip}}),function(root,factory){"use strict";"function"==typeof define&&define.amd?define("d3.relationshipGraph",["d3"],factory):"object"==typeof exports&&"object"==typeof module?module.exports=factory(require("d3")):"object"==typeof exports?exports.d3.relationshipGraph=factory(require("d3")):root.d3.relationshipGraph=factory(root.d3)}(this,function(d3){"use strict";var containsKey=function(obj,key){return Object.keys(obj).indexOf(key)>-1},contains=function(arr,key){return arr.indexOf(key)>-1},truncate=function(str,cap){return 0===cap?str:str.length>cap?str.substring(0,cap)+"...":str},isArray=function(arr){return"[object Array]"==Object.prototype.toString.call(arr)},noop=function(){};d3.relationshipGraph=function(){return RelationshipGraph.extend.apply(RelationshipGraph,arguments)},d3.selection.prototype.relationshipGraph=function(userConfig){return new RelationshipGraph(this,userConfig)},d3.selection.enter.prototype.relationshipGraph=function(){return this.graph};var RelationshipGraph=function(selection,userConfig){if(void 0===userConfig.thresholds||"object"!=typeof userConfig.thresholds)throw"Thresholds must be an Object.";this.config={blockSize:24,selection:selection,showTooltips:userConfig.showTooltips,maxChildCount:userConfig.maxChildCount||0,onClick:userConfig.onClick||noop,showKeys:userConfig.showKeys,thresholds:userConfig.thresholds,colors:userConfig.colors||["#c4f1be","#a2c3a4","#869d96","#525b76","#201e50","#485447","#5b7f77","#6474ad","#b9c6cb","#c0d6c1","#754668","#587d71","#4daa57","#b5dda4","#f9eccc","#0e7c7b","#17bebb","#d4f4dd","#d62246","#4b1d3f","#cf4799","#c42583","#731451","#f3d1bf","#c77745"],transitionTime:userConfig.transitionTime||1500,truncate:userConfig.truncate||25},void 0===this.config.showTooltips&&(this.config.showTooltips=!0),void 0===this.config.showKeys&&(this.config.showKeys=!0),this.config.thresholds.length>0&&"number"==typeof this.config.thresholds[0]&&this.config.thresholds.sort(),this.ctx=document.createElement("canvas").getContext("2d"),this.ctx.font="13px Helvetica";var createTooltip=function(self){var hiddenKeys=["ROW","INDEX","COLOR","PARENTCOLOR","PARENT"],showKeys=self.config.showKeys;return d3.tip().attr("class","relationshipGraph-tip").offset([-8,-10]).html(function(obj){for(var keys=Object.keys(obj),table=document.createElement("table"),count=keys.length,rows=[];count--;){var element=keys[count],upperCaseKey=element.toUpperCase();if(!contains(hiddenKeys,upperCaseKey)){var row=document.createElement("tr"),key=showKeys?document.createElement("td"):null,value=document.createElement("td");showKeys&&(key.innerHTML=element.charAt(0).toUpperCase()+element.substring(1),row.appendChild(key)),value.innerHTML=obj[element],value.style.fontWeight="normal",row.appendChild(value),rows.push(row)}}for(var rowCount=rows.length;rowCount--;)table.appendChild(rows[rowCount]);return self.tip.direction("n"),table.outerHTML})};this.config.showTooltips?this.tip=createTooltip(this):this.tip=null,this.svg=this.config.selection.select("svg").select("g"),this.svg.empty()&&(this.svg=this.config.selection.append("svg").attr("width","500").attr("height","500").attr("style","display: block").append("g").attr("transform","translate(10, 0)")),this.graph=this};return RelationshipGraph.prototype.verifyJson=function(json){if(!isArray(json)||json.length<0||"object"!=typeof json[0])throw"JSON has to be an Array of JavaScript objects that is not empty.";for(var length=json.length;length--;){var element=json[length],keys=Object.keys(element),keyLength=keys.length;if(void 0===element.parent)throw"Child does not have a parent.";if(void 0!==element.parentColor&&(element.parentColor>4||element.parentColor<0))throw"Parent color is unsupported.";for(;keyLength--;)if("VALUE"==keys[keyLength].toUpperCase()){"value"!=keys[keyLength]&&(json[length].value=json[length][keys[keyLength]],delete json[length][keys[keyLength]]);break}}return!0},RelationshipGraph.prototype.data=function(json){if(this.verifyJson(json)){var parent,i,maxWidth,maxHeight,row=1,index=1,previousParent=null,parents=[],parentSizes={},previousParentSizes=0,_this=this;for(json.sort(function(child1,child2){return child1.parent<child2.parent?-1:child1.parent>child2.parent?1:0}),i=0;i<json.length;i++)parent=json[i].parent,containsKey(parentSizes,parent)?parentSizes[parent]++:(parentSizes[parent]=1,parents.push(truncate(parent,this.config.truncate)));var longest="",parentNames=Object.keys(parentSizes);for(i=0;i<parents.length;i++){var current=parents[i]+" ( "+parentSizes[parentNames[i]]+") ";current.length>longest.length&&(longest=current)}var longestWidth=this.ctx.measureText(longest).width,parentDiv=this.config.selection[0][0],calculatedMaxChildren=0===this.config.maxChildCount?Math.floor((parentDiv.parentElement.clientWidth-15-longestWidth)/this.config.blockSize):this.config.maxChildCount;for(i=0;i<json.length;i++){var element=json[i];parent=element.parent,null!==previousParent&&previousParent!==parent?(element.row=row+1,element.index=1,index=2,row++):(index===calculatedMaxChildren+1&&(index=1,row++),element.row=row,element.index=index,index++),previousParent=parent;var value,compare;"string"==typeof _this.config.thresholds[0]?(value=element.value,compare=function(value,threshold){return value==threshold}):(value="number"==typeof element.value?element.value:parseInt(element.value.replace(/\D/g,"")),compare=function(value,threshold){return threshold>value});for(var thresholdIndex=0;thresholdIndex<_this.config.thresholds.length;thresholdIndex++)if(compare(value,_this.config.thresholds[thresholdIndex])){element.color=thresholdIndex;break}}maxHeight=row*this.config.blockSize,maxWidth=longestWidth+calculatedMaxChildren*this.config.blockSize;var parentNodes=this.svg.selectAll(".relationshipGraph-Text").data(parents);parentNodes.enter().append("text").text(function(obj,index){return obj+" ("+parentSizes[Object.keys(parentSizes)[index]]+")"}).attr("x",0).attr("y",function(obj,index){if(0===index)return 0;var y=Math.ceil(previousParentSizes/calculatedMaxChildren)*_this.config.blockSize;return previousParentSizes+=y,y}).style("text-anchor","start").style("fill",function(obj){return void 0!==obj.parentColor?_this.config.colors[obj.parentColor]:"#000000"}).attr("class","relationshipGraph-Text").attr("transform","translate(-6, "+this.config.blockSize/1.5+")"),parentNodes.text(function(obj,index){return obj+" ("+parentSizes[Object.keys(parentSizes)[index]]+")"}).attr("y",function(obj,index){if(0===index)return 0;for(var previousParentSize=0,i=index-1;i>-1;)previousParentSize+=Math.ceil(parentSizes[Object.keys(parentSizes)[i]]/calculatedMaxChildren)*calculatedMaxChildren,i--;return Math.ceil(previousParentSize/calculatedMaxChildren)*_this.config.blockSize}).style("fill",function(obj){return void 0!==obj.parentColor?_this.config.colors[obj.parentColor]:"#000000"}),parentNodes.exit().remove();var childrenNodes=this.svg.selectAll(".relationshipGraph-block").data(json);childrenNodes.enter().append("rect").attr("x",function(obj){return longestWidth+(obj.index-1)*_this.config.blockSize}).attr("y",function(obj){return(obj.row-1)*_this.config.blockSize}).attr("rx",4).attr("ry",4).attr("class","relationshipGraph-block").attr("width",_this.config.blockSize).attr("height",_this.config.blockSize).style("fill",function(obj){return _this.config.colors[obj.color%_this.config.colors.length]||_this.config.colors[0]}).on("mouseover",_this.tip?_this.tip.show:noop).on("mouseout",_this.tip?_this.tip.hide:noop).on("click",function(obj){_this.tip.hide(),_this.config.onClick(obj)}),childrenNodes.transition(_this.config.transitionTime).attr("x",function(obj){return longestWidth+(obj.index-1)*_this.config.blockSize}).attr("y",function(obj){return(obj.row-1)*_this.config.blockSize}).style("fill",function(obj){return _this.config.colors[obj.color%_this.config.colors.length]||_this.config.colors[0]}),childrenNodes.exit().transition(_this.config.transitionTime).remove(),this.config.showTooltips&&(d3.select(".d3-tip").remove(),this.svg.call(this.tip)),this.config.selection.select("svg").attr("width",maxWidth+15).attr("height",maxHeight+15)}return this},RelationshipGraph});