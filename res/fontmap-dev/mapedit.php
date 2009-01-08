<?php 
include "res.php";
?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>YANC Font Map Editor</title>
<link href="style.css" rel="stylesheet" type="text/css"> 
</head>
<body>
<h1>YANC Font Map Editor</h1>


<form method="post" target="<?php echo $_SERVER['PHP_SELF']; ?>">
<h2>Unicode to Font</h2>
<table border='1'>
<tr>
<th>Code</th>
<th>Description</th>
<th>Glyph</th>
<th>Font</th>
<th>Variations (space separated)</th>
</tr>

<?php 

foreach ($devanagari as $d){
	echo "<tr>\n";
	printf("<td>U+0%x</td>\n",$d[0]);
	echo "<td>",$d[1],"</td>\n";
	printf("<td align='center'><span class='unicode-glyph'>&#x%x;</span></td>\n",$d[0]);
	printf("<td><input type='text' name='unicode-%d' size='5' class='input-dev2font' /></td>\n",$d[0]);
	printf("<td><input type='text' name='unicode-%d-var' class='input-dev2font' /></td>\n",$d[0]);
	echo "</tr>\n";
	
}

?>
</table>

<h2>Font to Unicode</h2>
<table border='1'>
<tr>
<th>Code</th>
<th>Glyph</th>
<th>Unicode</th>
<th>Variations (space separated)</th>
</tr>

<?php 

for ($n=33;$n<=255;$n++){
	echo "<tr>\n";
	printf("<td>U+0%x</td>\n",$n);
	printf("<td align='center'><span class='font-glyph'>&#x%x;</span></td>\n",$n);
	printf("<td><input type='text' name='font-%d' size='5' class='input-font2dev' /></td>\n",$n);
	printf("<td><input type='text' name='font-%d-var' class='input-font2dev' /></td>\n",$n);
	echo "</tr>\n";
	
}

?>
</table>

</form>

</body>
</html>