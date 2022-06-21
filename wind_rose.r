install.packages("openair")
library(openair)

library(readr)
data <- read_delim("data.csv", delim = ";", 
+     escape_double = FALSE, col_names = FALSE, 
+     trim_ws = TRUE)

windRose(data, ws="X3", wd="X2")

windRose(data, ws="X3", wd="X2",
breaks=c(0,3,5,8,11,14),
auto.text=FALSE,
paddle=FALSE,
annotate=FALSE,
grid.line=5,
key=list(labels=c("очень слабый","слабый","умеренный","свежий","сильный")),
key.footer="Скорость ветра (м/с)",
key.position="bottom",
par.settings=list(axis.line=list(col="lightgray")),
col=c("#4f4f4f", "#0a7cb9","#f9be00","#ff7f2f","#d7153a")
)