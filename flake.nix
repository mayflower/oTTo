{
  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-22.11";
    nixpkgs-unstable.url = "github:nixos/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };
  outputs = {
    self,
    nixpkgs,
    nixpkgs-unstable,
    flake-utils,
    ...
  }:
    flake-utils.lib.eachDefaultSystem (system: let
      pkgs = import nixpkgs { inherit system; overlays = [ self.overlays.${system}.default ]; };
      pkgs-unstable = import nixpkgs-unstable { inherit system; };
    in {
      devShells.default = pkgs.mkShell {
        name = "otto-dev";
        buildInputs = with pkgs; [
            pkgs.minikube
            pkgs.skaffold
            pkgs.openjdk
            pkgs.nodejs-18_x
            pkgs.buildpack
            pkgs.kubernetes-helm
        ];
      };
      overlays.default = (final: prev: {
        skaffold = pkgs-unstable.skaffold;
      });
  });
}