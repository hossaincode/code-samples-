setwd("d:/R work/Bioinformatics Assignment 2/text_networks")
weight=-0.00001
l=28
h=33
vectorAll=c()
for(i in 1:35)
{
	FileNm=paste("network_",i,sep ="")
	tempTable=read.table(FileNm)
	vectornodeUnique=union(unique(tempTable[,1]),unique(tempTable[,2]))
	vectorAll=union(vectorAll,vectornodeUnique)
	
}
nouniqueNode=length(vectorAll)
summaryMatrix=matrix(0,nouniqueNode,nouniqueNode)
rownames(summaryMatrix)<-vectorAll
colnames(summaryMatrix)<-vectorAll

for(k in 1:35)
{
	FileNm=paste("network_",k,sep ="")
	tempTable=read.table(FileNm)
	for(j in 1:dim(tempTable)[1])
	{
		
		summaryMatrix[as.character(tempTable[j,1]),as.character(tempTable[j,2])]=summaryMatrix[as.character(tempTable[j,1]),as.character(tempTable[j,2])]+1
		
		
			
		
	}

}

for( i in 11:15)
{	
	ids=which(summaryMatrix>=i,arr.ind=T)
	FileName=paste("summarygraph",i,sep ="")
	write.table(ids,file=FileName,row.name=F,col.name=F,quote=F)
	


}
FileNam=paste("summarygraph",15,sep ="")
tempTabledge=read.table(FileNam)
edgeListforward=paste(vectorAll[tempTabledge[,1]],vectorAll[tempTabledge[,2]])
edgeListbackward=paste(vectorAll[tempTabledge[,2]],vectorAll[tempTabledge[,1]])

mafiaMatrix=matrix(nrow = 35, ncol = 1)

for(k in 1:35)
{
	FileNm=paste("network_",k,sep ="")
	tempTabl=read.table(FileNm)
	dataBase=paste(tempTabl[,1],tempTabl[,2])
	occurenceForward=which(edgeListforward %in% dataBase)
	occurenceBackward=which(edgeListbackward %in% dataBase)

	ocuurenceunique=unique(c(occurenceForward,occurenceBackward))
	itemList=paste(ocuurenceunique,collapse=" ")
	
	mafiaMatrix[k,]=itemList
}
write.table(mafiaMatrix,file="mafiainputfor.txt",row.name=F,col.name=F,quote=F)

FileNm=paste("summarygraph",15,sep ="")
graph=read.graph(FileNm,format = "ncol",directed=FALSE)
Table1<-c()
for(j in l:h)
{	
	FileNm=paste("maximal",j,".txt",sep ="")
	tempTable=as.matrix(read.table(FileNm,sep="("))

	freqEdgeSet=dim(tempTable)[1]
	totalNode=0
	totalEdge=0
	totalCc=0
	totalDensity=0
	
	for(k in 1:freqEdgeSet)
	{ 
		vn=as.numeric(unlist(strsplit(tempTable[k,1], " ")))

		graphEach=subgraph.edges(graph,vn,delete.vertices = TRUE)
		totalNode=totalNode+length(V(graphEach))
		totalEdge=totalEdge+length(E(graphEach))
		totalCc=totalCc+components(graphEach)$no
		totalDensity=totalDensity+graph.density(graphEach)
		
		
	}
	Table1<- rbind(Table1,c(j,freqEdgeSet,(totalNode/freqEdgeSet),(totalEdge/freqEdgeSet),(totalCc/freqEdgeSet),totalDensity/freqEdgeSet))
	
 
}
colnames(Table1)<-c("Alpha","|M|","|V|","|E|","|CC|","Density")

write.table(Table1,file="Table1.txt",row.name=F,col.name=T,quote=F)
