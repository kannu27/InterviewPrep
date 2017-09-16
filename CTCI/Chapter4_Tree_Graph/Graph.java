public class Graph{
  Project[] projects;

  public Graph(String[] projs){
    projects = new Projects[projs.length];
    for(int i = 0; i < projects.length;i++){
      projects[i] = new Project(projs[i]);
    }
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < this.projects.length;i++){
      sb.append(projects[i].name);
      sb.append(",");
      }
      return sb.toString();
    }


  class Project{
    private String name;
    private LinkedList<Project> adj;

    public Project(String name){
      this.name = name;
    }
    public Project(String name, LinkedList<Project> adjacent){
      this.name = name;
      this.adj = adjacent;
    }

    public void addPrereq(Project b){
        this.adj.add(b);
    }
  }

  public static void main(String[] args){
        String[] projs = {"a", "b","c", "d", "e"};
        Graph build = new Graph(projs);
        System.out.println(build.toString());

  }
}
