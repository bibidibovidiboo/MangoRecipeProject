<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
$symbolSize: 1em;
$symbolThickness: 0.2em;

body {
  font-family: 'Montserrat', sans-serif;
}

.deselected-tags {
  height: 1500px;
  padding: 0.5em 0;
  width: 3000px;
  box-sizing: border-box;
  overflow: auto;
  -webkit-overflow-scrolling: touch;
  background: #ffedd6;
}

.selection-container {
  padding-top: 1em;
  box-shadow: 0 -2px 15px rgba(black, 0.2), 0 -1px 3px rgba(black, 0.4);
  position: relative;
  background: white;
  z-index: 1;
  height: 50vh;
  width: 100%;
  box-sizing: border-box;
  overflow: auto;
  -webkit-overflow-scrolling: touch;
}

.copy-confirmation {
  position: fixed;
  bottom: 0;
  background: orange;
  color: white;
  width: 100%;
  padding: 3em 0;
  text-align: center;
  font-weight: bold;
  z-index: 3;
  transform: translate(0, 100%);

  .flash & {
    animation: flash-message 1.3s linear;
  }
}

.selection-total {
  $pad: 0.7em;

  font-size: 0.8em;
  font-weight: bold;
  position: absolute;
  background: white;
  color: #84786a;
  right: 0;
  margin-top: -0.5em - $pad;
  z-index: 2;
  min-width: 4.8em;
  padding: $pad $pad/2 $pad 0;
  text-align: right;
  border-top-left-radius: 99em;
  border-bottom-left-radius: 99em;
  box-shadow: 0 3px 10px rgba(0, 0, 0, 0.09), 0 2px 3px rgba(0, 0, 0, 0.12);
}

.tag {
  touch-action: manipulation;
  font-size: 0.8em;
  font-family: 'Montserrat', sans-serif;
  font-weight: bold;

  color: gray;

  display: inline-block;

  border: 4px solid;
  border-radius: 999em;
  padding: 0.7em $symbolSize*2 0.7em 1em;
  min-width: 7em;
  text-align: left;

  margin: 0.3em;

  position: relative;

  // Used for offsetting symbols
  $xOffset: ($symbolSize/2 - $symbolThickness/2) * -1;
  $yOffset: ($symbolSize/2 - $symbolThickness/2);

  &:before, &:after {
    position: absolute;
    content: '';
    background: currentColor;
    right: 0.4em;
    top: 0.9em;
  }

  &:before { // |
    width: $symbolThickness;
    height: $symbolSize;
  }

  &:after { // --
    width: $symbolSize;
    height: $symbolThickness;
  }

  &--deselected {
    background: white;
    border-color: white;
    box-shadow: 0 1px 10px rgba(0, 0, 0, 0.09), 0 1px 1px rgba(0, 0, 0, 0.25);
    animation: bloop 2000ms linear both;

    &:before {
      transform: translate($xOffset, 0);
    }
    &:after {
      transform: translate(0, $yOffset);
    }
  }

  &--selected {
    background: currentColor;
    animation: jelly 700ms linear both;

    span {
      color: white;
    }

    &:before, &:after {
      background: white;
    }

    &:before {
      transform: translate($xOffset, 0) rotate(45deg);
    }
    &:after {
      transform: translate(0, $yOffset) rotate(45deg);
    }
  }
}

.copy-button-wrapper {
  margin: 1em 0.5em 2em;
}

.copy-button {
  color: #009fe0;
  background: white;
  font-size: 1.5em;
  padding: 0.5em;
  display: block;
  box-sizing: border-box;
  border: 4px solid;
  width: 100%;
  font-weight: bold;
  font-family: inherit;
  border-radius: 99em;

  svg {
    width: 1em;
    display: inline-block;
    vertical-align: middle;
    margin-left: 0.2em;

    path {
      fill: currentColor;
    }
  }
}

/* Generated with Bounce.js. Edit at https://goo.gl/T2pMyb */

@keyframes jelly { 
  0% { transform: matrix3d(1.5, 0, 0, 0, 0, 1.5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  3.4% { transform: matrix3d(1.342, 0, 0, 0, 0, 1.297, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  4.7% { transform: matrix3d(1.275, 0, 0, 0, 0, 1.2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  6.81% { transform: matrix3d(1.17, 0, 0, 0, 0, 1.054, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  9.41% { transform: matrix3d(1.058, 0, 0, 0, 0, 0.916, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  10.21% { transform: matrix3d(1.029, 0, 0, 0, 0, 0.887, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  13.61% { transform: matrix3d(0.938, 0, 0, 0, 0, 0.834, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  14.11% { transform: matrix3d(0.93, 0, 0, 0, 0, 0.835, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  17.52% { transform: matrix3d(0.896, 0, 0, 0, 0, 0.88, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  18.72% { transform: matrix3d(0.894, 0, 0, 0, 0, 0.906, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  21.32% { transform: matrix3d(0.902, 0, 0, 0, 0, 0.965, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  24.32% { transform: matrix3d(0.925, 0, 0, 0, 0, 1.02, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  25.23% { transform: matrix3d(0.933, 0, 0, 0, 0, 1.031, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  29.03% { transform: matrix3d(0.969, 0, 0, 0, 0, 1.052, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  29.93% { transform: matrix3d(0.976, 0, 0, 0, 0, 1.051, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  35.54% { transform: matrix3d(1.01, 0, 0, 0, 0, 1.019, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  36.74% { transform: matrix3d(1.014, 0, 0, 0, 0, 1.011, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  41.04% { transform: matrix3d(1.02, 0, 0, 0, 0, 0.989, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  44.44% { transform: matrix3d(1.017, 0, 0, 0, 0, 0.984, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  52.15% { transform: matrix3d(1.004, 0, 0, 0, 0, 0.997, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  59.86% { transform: matrix3d(0.997, 0, 0, 0, 0, 1.005, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  63.26% { transform: matrix3d(0.996, 0, 0, 0, 0, 1.004, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  75.28% { transform: matrix3d(0.999, 0, 0, 0, 0, 0.998, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  85.49% { transform: matrix3d(1.001, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  90.69% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  100% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); } 
}

@keyframes bloop { 
  0% { transform: matrix3d(0.6, 0, 0, 0, 0, 0.6, 0, 0, 0, 0, 1, 0, 0, 6, 0, 1); }
  1.58% { transform: matrix3d(0.794, 0, 0, 0, 0, 0.794, 0, 0, 0, 0, 1, 0, 0, 6.392, 0, 1); }
  3.15% { transform: matrix3d(0.952, 0, 0, 0, 0, 0.952, 0, 0, 0, 0, 1, 0, 0, 5.85, 0, 1); }
  4.3% { transform: matrix3d(1.02, 0, 0, 0, 0, 1.02, 0, 0, 0, 0, 1, 0, 0, 4.953, 0, 1); }
  4.73% { transform: matrix3d(1.035, 0, 0, 0, 0, 1.035, 0, 0, 0, 0, 1, 0, 0, 4.565, 0, 1); }
  6.27% { transform: matrix3d(1.056, 0, 0, 0, 0, 1.056, 0, 0, 0, 0, 1, 0, 0, 3.109, 0, 1); }
  8.61% { transform: matrix3d(1.033, 0, 0, 0, 0, 1.033, 0, 0, 0, 0, 1, 0, 0, 1.254, 0, 1); }
  10.16% { transform: matrix3d(1.013, 0, 0, 0, 0, 1.013, 0, 0, 0, 0, 1, 0, 0, 0.394, 0, 1); }
  12.12% { transform: matrix3d(0.998, 0, 0, 0, 0, 0.998, 0, 0, 0, 0, 1, 0, 0, -0.325, 0, 1); }
  12.91% { transform: matrix3d(0.995, 0, 0, 0, 0, 0.995, 0, 0, 0, 0, 1, 0, 0, -0.52, 0, 1); }
  14.05% { transform: matrix3d(0.994, 0, 0, 0, 0, 0.994, 0, 0, 0, 0, 1, 0, 0, -0.724, 0, 1); }
  17.22% { transform: matrix3d(0.998, 0, 0, 0, 0, 0.998, 0, 0, 0, 0, 1, 0, 0, -0.931, 0, 1); }
  21.83% { transform: matrix3d(1.001, 0, 0, 0, 0, 1.001, 0, 0, 0, 0, 1, 0, 0, -0.7, 0, 1); }
  28.33% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, -0.206, 0, 1); }
  29.64% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, -0.135, 0, 1); }
  35% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0.033, 0, 1); }
  39.44% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0.062, 0, 1); }
  61.66% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, -0.004, 0, 1); }
  83.98% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); }
  100% { transform: matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1); } 
}

@keyframes flash-message{
  0% {
    transform:  translate(0px,100%)  ;
  }
  5% {
    transform:  translate(0px,10%)  ;
  }
  10% {
    transform:  translate(0px,5%)  ;
  }
  25% {
    transform:  translate(0px,0%)  ;
  }
  94% {
    transform:  translate(0px,0%)  ;
  }
  100% {
    transform:  translate(0px,100%)  ;
  }
}
</style>
<script type="text/javascript">
var deselected = document.querySelector('.deselected-tags');
var selected = document.querySelector('.selected-tags');
var copyButton = document.querySelector('.copy-button');
var clipboard = new Clipboard(copyButton);
var selectedClass = 'tag--selected';
var deselectedClass = 'tag--deselected';

var defaultSelected = [
  'art',
  'crafts',
  'etsy'
];

var defaultDeselected = [
  'beyonce',
  'blessed',
  'boss',
  'bossbitch',
  'cats',
  'classy',
  'cute',
  'decoration',
  'dogs',
  'embroidery',
  'fancy',
  'feminism',
  'feminist',
  'floral',
  'funny',
  'gangsta',
  'gift',
  'handmade',
  'hiphop',
  'hoopart',
  'hottie',
  'iger',
  'instagood',
  'love',
  'lyrics',
  'pimp',
  'pretty',
  'script',
  'shop',
  'shop',
  'swag',
  'tvshow',
  'vintage',
  'wallart',
  'yasss'
];

function addTags(toEl, list, modifier) {
  list.forEach(function(item) {
    var tag = document.createElement('button');
    var span = document.createElement('span');
    var color = Please.make_color({
      seed: item.toLowerCase(), // so colors are consistent
      value: 0.8,
      saturation: 0.5
    });
    
    span.textContent = '#' + item;
    tag.classList.add('tag');
    tag.style.color = color; 
    
    if (modifier) {
      tag.classList.add('tag--' + modifier);
    }
     
    tag.appendChild(span);
    toEl.appendChild(tag);
  });
}

addTags(deselected, defaultDeselected, 'deselected');
addTags(selected, defaultSelected, 'selected');
updateSelected();

function selectEl(el) {
  selected.appendChild(el);
  el.classList.remove(deselectedClass);
  el.classList.add(selectedClass);
  updateSelected();
}

function deselectEl(el) {
  deselected.insertBefore(el, deselected.firstChild);
  el.classList.remove(selectedClass);
  el.classList.add(deselectedClass);
  updateSelected();
}

function updateSelected() {
  updateNumSelected();
  updateCopyText();
}

function updateNumSelected() {
  var numEl = document.querySelector('.num-selected');
  var num = selected.children.length;
  numEl.textContent = num;
}

function updateCopyText() {
  var selectedTagText = selected.textContent;
  selectedTagText = selectedTagText.replace(/#/g, ' #').trim();
  copyButton.dataset.clipboardText = selectedTagText;
}

updateCopyText();

deselected.addEventListener('click', function(e) {
  var t = e.target;
  
  if (t.matches('.tag > *')) {
    t = t.parentElement;
  }
  
  if (t.matches('.tag')) {
    selectEl(t);
  }
});

selected.addEventListener('click', function(e) {
  var t = e.target;
  
  if (t.matches('.tag > *')) {
    t = t.parentElement;
  }
  
  if (t.matches('.tag')) {
    deselectEl(t);
  }
});

clipboard.on('success', function(e) {
  e.clearSelection();
  document.activeElement.blur();
  var container = document.querySelector('.selection-container');
  container.classList.remove('flash');
  window.setTimeout(function() {
    container.classList.add('flash');
  }, 0);
});
</script>
</head>
<body>
<!-- We need to keep all the tags on a single line,
or else you get wacky whitespace when
copying to the clipboard. Also, display issues -->


<div class="deselected-tags"></div>

<div class="selection-total">
  <span class="num-selected"></span> / 30
</div>

<div class="selection-container">

  <div class="selected-tags"></div>


</div>
</body>
</html>