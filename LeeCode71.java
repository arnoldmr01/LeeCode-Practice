class Solution {
    public String simplifyPath(String path) {
        String[] pathList = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < pathList.length; i ++){
            if (pathList[i].isEmpty() || pathList[i].equals(".")){
                continue;
            }
            
            if (pathList[i].equals("..")){
                if (stack.isEmpty()) continue;

                stack.pop();
            }
            else{
                stack.push(pathList[i]);
            }
        }

        String[] array = stack.toArray(new String[0]);
        String a = String.join("/", array);
        return "/" + a;
    }
}

