class Gene {
    String id // identifier
    String parameter // affected parameter e.g. HAIR COLOR
    String value // value in gene

    String toString() {
        "[parameter: $parameter; value: $value]"
    }
}

// generally a character should have at least 20 different genes
// moreover genes might have variety and accumulating over time

class Character {
    def name
    def genes = []

    String toString() {
        "character name: $name\n" + "genes: $genes\n"
    }
}

def char1 = new Character()
char1.name = "Jean"
char1.genes = [
        new Gene(id: "GENE_1", parameter: "hair_color", "value": "red")
]

def char2 = new Character()
char2.name = "Jolie"
char2.genes = [
        new Gene(id: "GENE_2", parameter: "hair_color", "value": "green")
]

def cross(left, right) {
    def child = new Character()
    child.name = "Ack"
    child.genes = left.genes + right.genes

    child
}

def groupGenes(character) {
    character.genes.groupBy { gene -> gene.parameter }
}

println cross(char1, char2)
println groupGenes(cross(char1, char2))
